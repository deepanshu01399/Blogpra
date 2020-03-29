package com.deepanshu.android.blogpra;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import java.util.ArrayList;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {
    private Context context;
    private TextView textView;
    private int pos;
    ArrayList<Blog> blogs;

    RecyclerViewAdapter(ArrayList<Blog> blogs, Context context) {
        this.blogs = blogs;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.blog1, parent, false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.viewHolder holder, int position) {
        holder.title.setText(blogs.get(position).getTitle());
        holder.des.setText(blogs.get(position).getDescribe());
        holder.Author.setText(blogs.get(position).getAuthorName());
        pos = position;


        Glide.with(context)
                .load(blogs.get(position).getImgUrl())
                .into(holder.img);
        String stitle = blogs.get(position).getTitle();
        int titlestart=stitle.indexOf(stitle.charAt(0));
        int titleend=stitle.length();

        String swhn = blogs.get(position).getWhn();
        int whnstart=swhn.indexOf(swhn.charAt(0));
        int whnnend=swhn.length();

        String sON = blogs.get(position).getON();
        int ONstart=sON.indexOf(sON.charAt(0));
        int ONnend=sON.length();

        SpannableString ss=new SpannableString(stitle);
        SpannableString ss1=new SpannableString(swhn);
        SpannableString ss2=new SpannableString(sON);

        ForegroundColorSpan fgcsblack=new ForegroundColorSpan(Color.BLACK);
        ForegroundColorSpan fgcsDKGRAY=new ForegroundColorSpan(Color.DKGRAY);
        ForegroundColorSpan fgcsRED=new ForegroundColorSpan(Color.RED);

        ss.setSpan(fgcsblack,titlestart,titleend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.title.setText(ss);

        ss1.setSpan(fgcsDKGRAY,whnstart,whnnend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.whn.setText(ss1);

        ss2.setSpan(fgcsRED,ONstart,ONnend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        holder.ON.setText(ss2);

        String url = "https://transformglobalhealth.org";
        ss2.setSpan(new URLSpan(url), ONstart, ONnend, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

// set to textview
        holder.ON.setText(ss2);
        holder.ON.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView title, des, Author, ON, whn;
        private ImageView img, dlt;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            whn = (TextView) itemView.findViewById(R.id.whn);
            des = (TextView) itemView.findViewById(R.id.describe);
            img = (ImageView) itemView.findViewById(R.id.image);
            Author = (TextView) itemView.findViewById(R.id.authorName);
            ON = (TextView) itemView.findViewById(R.id.ON);
            dlt = (ImageView) itemView.findViewById(R.id.dlt);
            dlt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(context)
                            .setTitle("Delete this")
                            .setMessage("are u want to dlt this blog?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            blogs.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            Toast.makeText(context,"blog dlt succesfully",Toast.LENGTH_LONG).show();
                        }
                    })
                            .setNegativeButton(android.R.string.no,null)

                .setIcon(android.R.drawable.btn_star)
                .show();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String title1=title.getText().toString();
                    Toast.makeText(context,""+title1,Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
