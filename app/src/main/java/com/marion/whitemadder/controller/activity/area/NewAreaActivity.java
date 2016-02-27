package com.marion.whitemadder.controller.activity.area;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.marion.whitemadder.R;
import com.marion.whitemadder.model.Area;

/**
 * Copyright (c) 06/02/16 marion
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
public class NewAreaActivity extends AppCompatActivity {

    private AreaView mAreaView;
    ListView mLines;
    AreaLineAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newarea);

        mAreaView = (AreaView)findViewById(R.id.area_view);

        final Area area = new Area();
        area.addLine(1.750f, 50.00f);
        area.addLine(2.420f, 30.00f);
        area.addLine(3.620f, 45.50f);

        mAreaView.setArea(area);

        mLines = (ListView)findViewById(R.id.list_lines);

        mAdapter = new AreaLineAdapter(this, area);
        mLines.setAdapter(mAdapter);

        Button mButton = (Button)findViewById(R.id.button_add_line);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                area.addLine(area.getLineAtIndex(area.getLines().size()-1).getDistance(), 0f);
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        mAreaView.onResume();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        mAreaView.onPause();
    }
}
