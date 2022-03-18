package com.silentsecurity.customtiimepiker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

public class timepicker extends AppCompatDialogFragment  {

    private TimePicker time;

    timepickerListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder mBuilder= new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View mView=inflater.inflate(R.layout.layout_time,null);

        time=mView.findViewById(R.id.time);

        mBuilder.setView(mView)
                .setTitle("Set Time")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       String timeOn=time.getHour()+":";
                        String timeTo=time.getMinute()+"";


                        listener.aplyText(timeOn,timeTo);
                    }
                });
        return mBuilder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(timepickerListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must impliment timepicker");
        }

    }

    public interface timepickerListener{
        void aplyText(String timeOn,String timeTo);
    }
}