package com.geeks.counterfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class CounterFragment extends Fragment {

    private int counter = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView counterText = view.findViewById(R.id.counterText);
        Button incrementButton = view.findViewById(R.id.incrementButton);
        Button nextButton = view.findViewById(R.id.nextButton);

        incrementButton.setOnClickListener(v -> {
            counter++;
            counterText.setText(String.valueOf(counter));
        });

        nextButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("counterValue", counter);
            Navigation.findNavController(view).navigate(R.id.action_counterFragment_to_resultFragment, bundle);
        });
    }
}