package com.aplikasi.destinasiwisatasulteng;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    private RecyclerView listWisata;
    private ArrayList<Wisata> listItem = new ArrayList<>();
    public CategoryFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        listWisata = rootView.findViewById(R.id.rv_wisata);
        listItem = getOrderItemList();
        showRecyclerList();
        return rootView;
    }
    private ArrayList<Wisata> getOrderItemList(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDeskripsi = getResources().getStringArray(R.array.data_description);
        TypedArray dataFoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Wisata> orderItemList = new ArrayList<>();
        for (int i = 0; i<dataName.length; i++){
            Wisata wisata = new Wisata();
            wisata.setDescription(dataDeskripsi[i]);
            wisata.setName(dataName[i]);
            wisata.setPhoto(dataFoto.getResourceId(i, -1));
            orderItemList.add(wisata);
        }
        return orderItemList;
    }
    private void showSelectedWisata(Wisata wisata){
        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity3.class);
        intent.putExtra("data_name", wisata.getName());
        intent.putExtra("data_description", wisata.getDescription());
        intent.putExtra("data_photo", wisata.getPhoto());
        startActivity(intent);
    }
    private void showRecyclerList(){
        listWisata.setLayoutManager(new LinearLayoutManager(getActivity()));
        WisataAdapter wisataAdapter = new WisataAdapter(listItem);
        listWisata.setAdapter(wisataAdapter);

        wisataAdapter.setOnItemClickCallback(this::showSelectedWisata);
    }
}