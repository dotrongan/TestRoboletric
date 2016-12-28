package com.example.andt.testroboletric;

import android.app.Activity;
import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class TestMainActivity {

	Activity activity;

	@Before
	public void setup() {
		activity = Robolectric.buildActivity(MainActivity.class).create().get();
	}

	@Test
	public void testStringExtra() {
		activity.findViewById(R.id.button).performClick();
		ShadowActivity shadowActivity = shadowOf(activity);
		Intent intent = shadowActivity.peekNextStartedActivity();
		String actual = intent.getStringExtra("message");
		assertThat(actual, is("FromMainActivity"));
	}

	@Test
	public void testStartActivityAndPutExtra() {
		activity.findViewById(R.id.button).performClick();
		ShadowActivity shadowActivity = shadowOf(activity);
		Intent intent = shadowActivity.peekNextStartedActivity();
		ShadowIntent shadowIntent = shadowOf(intent);
		String actualClassName = shadowIntent.getIntentClass().getName();
		System.out.println("actualClassName = "+actualClassName);
		assertThat(actualClassName, is(NewActivity.class.getName()));
	}

}