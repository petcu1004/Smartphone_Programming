package kr.co.company.to_do_list;

import android.app.AlarmManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.GregorianCalendar;


public class TodayFragment extends Fragment implements TimePicker.OnTimeChangedListener{

    View view;


    public TodayFragment() {
    }

    public static TodayFragment newInstance() {
        TodayFragment fragment = new TodayFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_today, container, false);





        return view;
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

    }
}