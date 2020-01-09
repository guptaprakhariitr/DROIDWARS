/*package com.example.doraemonapp.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/*import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doraemonapp.R;

import java.util.List;

public class BookmarkList extends ArrayAdapter<Bookmarks> {
    private Activity context;
    private List<Bookmarks> bookmarksList;
    public BookmarkList(Activity context,List<Bookmarks> bookmarksList){
        super(context,R.layout.bookmarklist,bookmarksList);
        this.context=context;
        this.bookmarksList=bookmarksList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listitems=inflater.inflate(R.layout.fragment_data,null,true);
        TextView textViewData=listitems.findViewById((R.id.bookmarkData));
        Bookmarks bookmarkList=bookmarksList.get(position);
        textViewData.setText(bookmarkList.getBmdata());
        return listitems;
    }
}
*/