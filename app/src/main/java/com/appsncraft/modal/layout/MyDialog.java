package com.appsncraft.modal.layout;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.appsncraft.modal.R;

import static android.R.layout.simple_spinner_dropdown_item;
import static com.appsncraft.modal.R.id.cores;
import static com.appsncraft.modal.R.layout.fragment_dialog;


public class MyDialog extends DialogFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    ImageButton close;
    ImageButton item1;
    ImageButton item2;
    ImageButton item3;
    Spinner subcategoria;
    String[] item1AList;
    String[] item1BList;
    String[] item1CList;
    String[] item2List;
    String[] item3List;
    ArrayAdapter<String> adapter1;
    Spinner tamanho;
    String[] tamanho1;
    String[] tamanho2;
    String[] tamanho3;
    String[] tamanho4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(fragment_dialog, container, false);
        close = (ImageButton) view.findViewById(R.id.close);
        item1 = (ImageButton) view.findViewById(R.id.item1);
        item2 = (ImageButton) view.findViewById(R.id.item2);
        item3 = (ImageButton) view.findViewById(R.id.item3);
        close.setOnClickListener(this);
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);

        view.setOnClickListener(this);
        getDialog().setCanceledOnTouchOutside(false);

        subcategoria = (Spinner) view.findViewById(R.id.subcategoria);
        item1AList = getResources().getStringArray(R.array.item1);
        item1BList = getResources().getStringArray(R.array.item2);
        item1CList = getResources().getStringArray(R.array.item3);

        tamanho = (Spinner) view.findViewById(R.id.tamanho);
        tamanho1 = getResources().getStringArray(R.array.tamanho1);
        tamanho2 = getResources().getStringArray(R.array.tamanho2);
        tamanho3 = getResources().getStringArray(R.array.tamanho3);
        tamanho4 = getResources().getStringArray(R.array.tamanho4);

        Spinner sexo = (Spinner) view.findViewById(R.id.sexo);
        String[] sexoList = getResources().getStringArray(R.array.sexo);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getContext(), simple_spinner_dropdown_item, sexoList);
        sexo.setAdapter(adapter3);

        EditText priceEditText = (EditText) view.findViewById(R.id.preco);
        priceEditText.clearFocus();

        return view;
    }

//    public void onRadioButtonClicked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//
//        switch(view.getId()) {
//            case R.id.radio1:
//                if (checked)
//                    // rule
//                    break;
//            case R.id.radio2:
//                if (checked)
//                    break;
//            case R.id.radio3:
//                if (checked)
//                    break;
//            case R.id.radio4:
//                if (checked)
//                    break;
//            case R.id.radio5:
//                if (checked)
//                    break;
//            case R.id.radio6:
//                if (checked)
//                    break;
//            case R.id.radio7:
//                if (checked)
//                    break;
//            case R.id.radio8:
//                if (checked)
//                    break;
//            case R.id.radio9:
//                if (checked)
//                    break;
//            case R.id.radio10:
//                if (checked)
//                    break;
//            case R.id.radio11:
//                if (checked)
//                    break;
//            case R.id.radio12:
//                if (checked)
//                    break;
//        }
//    }

    @Override
    public void onClick(View v) {

        RadioButton radio = (RadioButton) v.findViewById(cores);
        int click = v.getId();
        switch (click) {
            case R.id.close:
                dismiss();
                break;

            case R.id.item1:
                item1.setImageResource(R.drawable.ic_item1_selected);
                item2.setImageResource(R.drawable.ic_item2);
                item3.setImageResource(R.drawable.ic_item3);
                adapter1 = new ArrayAdapter<String>(this.getContext(), simple_spinner_dropdown_item, item1AList);
                subcategoria.setAdapter(adapter1);
                subcategoria.setOnItemSelectedListener(this);
                break;

            case R.id.item2:
                item1.setImageResource(R.drawable.ic_item1);
                item2.setImageResource(R.drawable.ic_item2_selected);
                item3.setImageResource(R.drawable.ic_item3);
                adapter1 = new ArrayAdapter<String>(this.getContext(), simple_spinner_dropdown_item, item1BList);
                subcategoria.setAdapter(adapter1);
                subcategoria.setOnItemSelectedListener(this);
                break;

            case R.id.item3:
                item1.setImageResource(R.drawable.ic_item1);
                item2.setImageResource(R.drawable.ic_item2);
                item3.setImageResource(R.drawable.ic_item3_selected);
                adapter1 = new ArrayAdapter<String>(this.getContext(), simple_spinner_dropdown_item, item1CList);
                subcategoria.setAdapter(adapter1);
                subcategoria.setOnItemSelectedListener(this);
                break;
        }
    }


    public void setSpinner(View view, String[] tamanhoList) {
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(view.getContext(), simple_spinner_dropdown_item, tamanhoList);
        tamanho.setAdapter(adapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String subcategoria = parent.getItemAtPosition(position).toString();

        switch (subcategoria) {
            case "Camisa":
                item2List = tamanho1;
                break;
            case "Calça":
                item2List = tamanho2;
                break;
            case "Vestido":
                item2List = tamanho2;
                break;
            case "Tênis":
                item2List = tamanho3;
                break;
            case "Sapato":
                item2List = tamanho3;
                break;
            case "Sandalha":
                item2List = tamanho3;
                break;
            case "Bolsa":
                item2List = tamanho4;
                break;
            case "Brinco":
                item2List = tamanho4;
                break;
            case "Colar":
                item2List = tamanho4;
                break;
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getContext(), simple_spinner_dropdown_item, item2List);
        tamanho.setAdapter(adapter2);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}