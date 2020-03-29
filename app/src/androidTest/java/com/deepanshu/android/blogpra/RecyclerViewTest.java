package com.deepanshu.android.blogpra;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class RecyclerViewTest {
    private static final int ITEMBELOWFINDINLIST = 4;

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);
    // click on an item of type String in a spinner
/*// afterwards verify that the view with the R.id.spinnertext_simple id contains "Eclipse"
    onData(allOf(is(instanceOf(String.class)), is("Eclipse"))).perform(click());
    onView(withId()).check(matches(withText(containsString("Eclipse")))); // normal view not adapter view

    onData(allOf(is(instanceOf(Map.class)), hasEntry(equalTo("STR"), is("item: 50"))).perform(click());

    onData(withItemContent("item: 60")).onChildView(withId(R.id.item_size)).perform(click());*/

    @Test
    public void recyclTest() {
        Espresso.onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void scrollToLast() {
        RecyclerView recyclerView = rule.getActivity().findViewById(R.id.my_recycler_view);
        int itemcount = recyclerView.getAdapter().getItemCount();
        Espresso.onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.scrollToPosition(itemcount - 1));
    }

    @Test
    public void titleDisplayOrNot() {
        Espresso.onView(withId(R.id.my_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(ITEMBELOWFINDINLIST, click()));
        String itemVal = "World Global health";
        Espresso.onView(withText(itemVal)).check(matches(isDisplayed()));
    }
}
