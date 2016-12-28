package com.example.andt.testroboletric;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowListView;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by ANDT on 12/27/2016.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestNewActivity {

	@Before
	public void setup1() {
		System.out.println("vao setup 1");
	}


	@Test
	public void messageIntentEquals() throws Exception {
		Intent intent = new Intent();
		intent.putExtra("message", "FromMainActivity");

		Activity activity = Robolectric.buildActivity(NewActivity.class).withIntent(intent).create().get();

		TextView text = (TextView) activity.findViewById(R.id.tvText);
		String actual = text.getText().toString();
		assertThat(actual, is("FromMainActivity"));
	}

	@Test
	public void messageIntentNotEquals() throws Exception {
		Activity activity = Robolectric.buildActivity(NewActivity.class).create().visible().get();

		TextView text = (TextView) activity.findViewById(R.id.tvText);
		String actual = text.getText().toString();
		assertThat(actual, is("not found message extra"));
	}

	@Before
	public void setup2() {
		System.out.println("vao setup 2");
	}

	@Test
	public void testOnDestroy() throws Exception {
		Activity activity = Robolectric.buildActivity(NewActivity.class).create().start().resume().pause().destroy().get();
		TextView text = (TextView) activity.findViewById(R.id.tvText);
		String actual = text.getText().toString();
		System.out.println("actual = "+actual);
		assertThat(actual, is("onDestroy"));
	}

	@Test
	public void testClickItemSuccess() {
		Activity activity = Robolectric.buildActivity(NewActivity.class).create().visible().get();
		ListView listView = (ListView) activity.findViewById(R.id.listview);
		ShadowListView shadowListView = shadowOf(listView);
		shadowListView.performItemClick(0);
		System.out.println("ketqua = "+listView.getAdapter().getItem(0).toString());
		assertThat("Samsung",is(listView.getAdapter().getItem(0).toString()));
		assertTrue("khong phai Sony","Sony".equals(listView.getAdapter().getItem(0).toString()));
	}

	@Test
	public void testClickItemGetResultError() {
		Activity activity = Robolectric.buildActivity(NewActivity.class).create().visible().get();
		ListView listView = (ListView) activity.findViewById(R.id.listview);
		ShadowListView shadowListView = shadowOf(listView);
		shadowListView.performItemClick(0);
		System.out.println("ketqua = "+listView.getAdapter().getItem(0).toString());
		assertTrue("khong phai Sony","Sony".equals(listView.getAdapter().getItem(0).toString()));
	}

}
