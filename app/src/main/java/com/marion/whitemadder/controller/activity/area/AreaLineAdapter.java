package com.marion.whitemadder.controller.activity.area;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.marion.whitemadder.R;
import com.marion.whitemadder.model.Area;
import com.marion.whitemadder.model.Line;

import java.util.Locale;

/**
 * Copyright (c) 26/02/16 marion
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR
 * ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
public class AreaLineAdapter extends ArrayAdapter<Line> {
    private final Context mContext;
    private final Area mArea;

    public AreaLineAdapter(Context context, Area area) {
        super(context, R.layout.row_area, area.getLines());
        this.mContext = context;
        this.mArea = area;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final AreaLineViewHolder mViewHolder;
        View vi = convertView;

        if(convertView == null) {

            mViewHolder = new AreaLineViewHolder();
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.row_area, parent, false);

            mViewHolder.startLineLabel = (TextView) vi.findViewById(R.id.start_line_label);
            mViewHolder.endLineField = (EditText) vi.findViewById(R.id.end_line_field);
            mViewHolder.speedField = (EditText) vi.findViewById(R.id.speed_field);
            mViewHolder.deleteButton = (Button) vi.findViewById(R.id.delete_button);

            vi.setTag(mViewHolder);

        }
        else{
            mViewHolder =   (AreaLineViewHolder) vi.getTag();
        }

        final Line line = mArea.getLines().get(position);
        if (line != null) {
            mViewHolder.speedField.setText(String.format(Locale.getDefault(), "%.3f", line.getAverage()));
            mViewHolder.speedField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Float value = 0f;
                    try {
                        value = Float.valueOf(s.toString());
                    } catch (Exception e) {
                    }
                    line.setAverage(value);
                }

                @Override
                public void afterTextChanged(Editable s) {
                    notifyDataSetChanged();
                }
            });
            mViewHolder.startLineLabel.setText(String.format(Locale.getDefault(), "%.3f", mArea.getStartLineDistance(line)));
            mViewHolder.endLineField.setText(String.format(Locale.getDefault(), "%.3f", line.getDistance()));
            mViewHolder.endLineField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Float value = 0f;
                    try {
                        value = Float.valueOf(s.toString());
                    } catch (Exception e) {
                    }
                    line.setDistance(value);
                }

                @Override
                public void afterTextChanged(Editable s) {
                    notifyDataSetChanged();
                }
            });
            mViewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mArea.getLines().remove(line);
                    notifyDataSetChanged();
                }
            });
        }


        return vi;
    }

    class AreaLineViewHolder {

        public TextView startLineLabel;
        public EditText endLineField;
        public EditText speedField;
        public Button deleteButton;
    }
}
