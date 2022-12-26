package com.demo.navigationpopup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BFragment extends Fragment {

    private static int bIndex = 0;
    private final int index;

    public BFragment() {
        bIndex ++;
        this.index = bIndex;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BFragment.
     */
    public static BFragment newInstance() {
        return new BFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.msg);
        textView.setText( String.format("This is %d BFragment!",index ) );
        view.findViewById(R.id.btn_back_a).setOnClickListener( v -> {
            /*
            NavDirections action = BFragmentDirections.actionBFragmentToAFragment();
            Navigation.findNavController(view).navigate(action);
             */
            Navigation.findNavController(view).popBackStack();
        } );
    }
}