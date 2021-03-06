package cuexpo.cuexpo2017.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

import cuexpo.cuexpo2017.R;


public class FacultyListItem extends BaseCustomViewGroup {

    public ImageView facultyBg;
    ImageView facultyIcon;
    TextView facultyTag, facultyTitle, facultyTitleEng;

    public FacultyListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public FacultyListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
    }

    public FacultyListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
    }

    @TargetApi(21)
    public FacultyListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
    }

    private void initInflate() {
        inflate(getContext(), R.layout.item_faculty, this);
    }

    private void initInstances() {
        facultyBg = (ImageView) findViewById(R.id.faculty_bg);
        facultyIcon = (ImageView) findViewById(R.id.faculty_icon);
        facultyTag = (TextView) findViewById(R.id.faculty_tag);
        facultyTitle = (TextView) findViewById(R.id.faculty_title);
        facultyTitleEng = (TextView) findViewById(R.id.faculty_title_eng);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    public TextView getFacultyTag() { return facultyTag;}
    public Drawable getFacultyBg() { return facultyBg.getDrawable();}
    public Drawable getfacultyIcon() { return facultyIcon.getDrawable();}
    public TextView getFacultyTitle() {return facultyTitle;}
    public TextView getFacultyTitleEng() {return facultyTitleEng;}

    public void setFacultyBg(int res) {
        facultyBg.setImageResource(res);
    }

    public void setFacultyIcon(int res) {
        facultyIcon.setImageResource(res);
    }

    public void setFacultyTag(String text, int textColor, int tagColor) {
        facultyTag.setText(text);
        facultyTag.setTextColor(textColor);
        facultyTag.setBackgroundResource(tagColor);
    }

    public void setFacultyTitle(String title) {
        facultyTitle.setText(title);
    }

    public void setFacultyTitleEng(String engTitle) {
        facultyTitleEng.setText(engTitle);
    }

}
