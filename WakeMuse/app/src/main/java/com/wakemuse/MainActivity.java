package com.wakemuse;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;

import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
	
	public final int REQ_CD_FP = 101;
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView textview1;
	private Button button1;
	private Button button2;
	private LinearLayout linear10;
	private LinearLayout linear7;
	private LinearLayout linear5;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear9;
	private LinearLayout linear6;
	private TextView textview3;
	private EditText edittext2;
	private Button button3;
	private ImageView imageview1;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear3;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear2;
	private TextView _drawer_textview1;
	
	private MediaPlayer media_player;
	private MediaPlayer mp;
	private SharedPreferences User_Data;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private SharedPreferences img;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		linear10 = findViewById(R.id.linear10);
		linear7 = findViewById(R.id.linear7);
		linear5 = findViewById(R.id.linear5);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear9 = findViewById(R.id.linear9);
		linear6 = findViewById(R.id.linear6);
		textview3 = findViewById(R.id.textview3);
		edittext2 = findViewById(R.id.edittext2);
		button3 = findViewById(R.id.button3);
		imageview1 = findViewById(R.id.imageview1);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		User_Data = getSharedPreferences("ToDo", Activity.MODE_PRIVATE);
		fp.setType("image/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		img = getSharedPreferences("img", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DialogFragment timePicker = new TimePickerFragment();
				                timePicker.show(getSupportFragmentManager(), "time picker");
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
				        Intent intent = new Intent(MainActivity.this, AlertReceiver.class);
				        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, intent, 0);
				
				        alarmManager.cancel(pendingIntent);
				        textview1.setText("Alarm canceled");
				if (mp.isPlaying()) {
					mp.stop();
				}
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				User_Data.edit().putString("Tag", edittext2.getText().toString()).commit();
				SketchwareUtil.showMessage(getApplicationContext(), "Saved !");
			}
		});
		
		imageview1.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
				return true;
			}
		});
	}
	
	private void initializeLogic() {
		edittext2.setText(User_Data.getString("Tag", ""));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				img.edit().putString("eimg1", _filePath.get((int)(0))).commit();
				imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img.getString("eimg1", ""), 1024, 1024));
				SketchwareUtil.showMessage(getApplicationContext(), "Image Has Been Set");
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		android.graphics.drawable.GradientDrawable gdt = new android.graphics.drawable.GradientDrawable(); gdt.setColor(Color.parseColor("#ffffff")); gdt.setCornerRadius(3); gdt.setStroke(5, Color.parseColor("#000000")); button1.setBackground(gdt);
		android.graphics.drawable.GradientDrawable gdt1 = new android.graphics.drawable.GradientDrawable(); gdt.setColor(Color.parseColor("#ffffff")); gdt.setCornerRadius(3); gdt.setStroke(5, Color.parseColor("#000000")); button2.setBackground(gdt);
		android.graphics.drawable.GradientDrawable gdt2 = new android.graphics.drawable.GradientDrawable(); gdt.setColor(Color.parseColor("#ffffff")); gdt.setCornerRadius(3); gdt.setStroke(5, Color.parseColor("#000000")); button3.setBackground(gdt);
		android.graphics.drawable.GradientDrawable gdt3 = new android.graphics.drawable.GradientDrawable(); gdt.setColor(Color.parseColor("#ffffff")); gdt.setCornerRadius(3); gdt.setStroke(5, Color.parseColor("#000000")); linear6.setBackground(gdt);
		if (img.getString("eimg1", "").equals("")) {
			
		}
		else {
			imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(img.getString("eimg1", ""), 1024, 1024));
		}
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
	public void _more() {
	}
	@Override
	    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		        Calendar c = Calendar.getInstance();
		        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
		        c.set(Calendar.MINUTE, minute);
		        c.set(Calendar.SECOND, 0);
		
		        _updateTimeText(c);
		        _startAlarm(c);
		    
	}
	
	
	public void _updateTimeText(final Calendar _c) {
		String timeText = "Task alarm set for: ";
		        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(_c.getTime());
		
		        textview1.setText(timeText);
	}
	
	
	public void _startAlarm(final Calendar _c) {
		AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		        Intent intent = new Intent(this, AlertReceiver.class);
		
		        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
		
		
		        if (_c.before(Calendar.getInstance())) {
			            _c.add(Calendar.DATE, 1);
			        }
		
		        alarmManager.setExact(AlarmManager.RTC_WAKEUP, _c.getTimeInMillis(), pendingIntent);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}