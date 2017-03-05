package cuexpo.chulaexpo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.HashMap;
import java.util.List;

import cuexpo.chulaexpo.dao.ActivityItemCollectionDao;
import cuexpo.chulaexpo.manager.StageManager;
import cuexpo.chulaexpo.view.StageInsideListItem;
import cuexpo.chulaexpo.view.StageListItem;

/**
 * Created by TEST on 1/14/2017.
 */

public class StageListAdapter extends BaseExpandableListAdapter {

    private List<StageListItem> listDataHeader;
    private HashMap<StageListItem, StageInsideListItem> listDataChild;
    private ActivityItemCollectionDao dao;

    public StageListAdapter(List<StageListItem> listDataHeader,
                            HashMap<StageListItem, StageInsideListItem> listChildData) {
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    public void setDao(ActivityItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return listDataChild.get(getGroup(groupPosition));
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        StageInsideListItem item = (StageInsideListItem) getChild(groupPosition, childPosition);

        if (groupPosition != getGroupCount() - 1) {
            item.setLineStatus(1);
        } else {
            item.setLineStatus(0);
        }

        StageListItem item2 = (StageListItem) getGroup(groupPosition);

        if (item.getSelected()) {
            item2.setNameHighlight(1);
        } else {
            item2.setNameHighlight(0);
        }

        return item;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        StageListItem item = (StageListItem) getGroup(groupPosition);
        StageManager manager = StageManager.getInstance();

        item.setStatus(manager.setCircle(item.getStartTime(), item.getEndTime(), item.getDay()));
        item.setLineMode(manager.setLine(groupPosition, getGroupCount()));
        item.setDrop(manager.setDrop(isExpanded));

        return item;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
