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

import com.example.signupformfragments.databinding.FragmentBirthdayBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BirthdayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayFragment extends Fragment {

   private FragmentBirthdayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_birthday,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.birthday.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.continueButtonMyBirthday.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButtonMyBirthday.setEnabled(true);
            }
        });

        binding.continueButtonMyBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(requireParentFragment()).navigate(R.id.destination_gender_fragment);
            }
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                returnToNameFragment();
            }
        });

    }

    private void returnToNameFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_birthday_fragment_pop);
    }




    public static BirthdayFragment newInstance(){
        return new BirthdayFragment();
    }
}