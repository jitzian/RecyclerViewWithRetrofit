package net.sgoliver.android.navigationdrawer;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.title), withText("Settings"), isDisplayed()));
        appCompatTextView.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(withClassName(is("android.widget.LinearLayout")),
                        withParent(allOf(withId(R.id.drawer_layout),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.appbar)),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatCheckedTextView = onView(
                allOf(withId(R.id.design_menu_item_text), withText("RecyclerView Static"), isDisplayed()));
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.appbar)),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatCheckedTextView2 = onView(
                allOf(withId(R.id.design_menu_item_text), withText("RecyclerView Retrofit"), isDisplayed()));
        appCompatCheckedTextView2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.appbar)),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction appCompatCheckedTextView3 = onView(
                allOf(withId(R.id.design_menu_item_text), withText("FireBase Messaging"), isDisplayed()));
        appCompatCheckedTextView3.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.logTokenButton), withText("Log Token"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.subscribeButton), withText("Subscribe To News"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Navigate up"),
                        withParent(withId(R.id.appbar)),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction appCompatCheckedTextView4 = onView(
                allOf(withId(R.id.design_menu_item_text), withText("OP2"), isDisplayed()));
        appCompatCheckedTextView4.perform(click());

//        ViewInteraction appCompatCheckedTextView5 = onView(
//                allOf(withId(R.id.design_menu_item_text), withText("OP1"), isDisplayed()));
//        appCompatCheckedTextView5.perform(click());

//        ViewInteraction appCompatCheckedTextView6 = onView(
//                allOf(withId(R.id.design_menu_item_text), withText("RecyclerView Static"), isDisplayed()));
//        appCompatCheckedTextView6.perform(click());
//
//        ViewInteraction appCompatImageButton5 = onView(
//                allOf(withContentDescription("Navigate up"),
//                        withParent(withId(R.id.appbar)),
//                        isDisplayed()));
//        appCompatImageButton5.perform(click());
//
//        ViewInteraction appCompatCheckedTextView7 = onView(
//                allOf(withId(R.id.design_menu_item_text), withText("RecyclerView Retrofit"), isDisplayed()));
//        appCompatCheckedTextView7.perform(click());

    }

}
