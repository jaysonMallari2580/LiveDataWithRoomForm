package com.example.signupformfragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.signupformfragments.databinding.FragmentFirstNameBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstNameFragment extends Fragment {

    private FragmentFirstNameBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first_name,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.firstName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.continueButtonMyName.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButtonMyName.setEnabled(true);

            }
        });

        binding.continueButtonMyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(requireParentFragment()).navigate(R.id.destination_birthday_fragment);
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                returnToEmailFragment();
            }
        });

    }

    private void returnToEmailFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_name_fragment_pop);
    }


    public static  FirstNameFragment newInstance(){
        return new FirstNameFragment();
    }
}