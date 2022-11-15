package com.example.throttle;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
        return inflater.inflate(R.layout.fragment_search, container, false);

    }

   @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        SearchView search = getView().findViewById(R.id.searchView);
        ListView listView = getView().findViewById(R.id.listView);

        List<String> buildTypes;
        buildTypes = new ArrayList<String>();
        String[] list = {"Stance", "Drifting", "Nascar", "Motorcross", "Rally", "Off-Roading", "Trucks", "Lowriders"};

        for(int i = 0; i < 8; i++)
       {
           buildTypes.add(list[i]);
       }

        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, buildTypes);

        listView.setAdapter(adapter);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search.clearFocus();

                //contain method would work better
                if(buildTypes.contains(query))
                {
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(getActivity(), "Item not found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });
    }
}

