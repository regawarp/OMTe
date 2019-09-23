package com.safetyfirst.omte;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class SignInUpActivity extends AppCompatActivity {

    private static final int AUTHUI_REQUEST_CODE = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_up);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }
    }

    public void handleSignInSignUp(View view) {
        List<AuthUI.IdpConfig> provider = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build()
        );
        Intent intent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(provider)
                .setTosAndPrivacyPolicyUrls("https://example.com", "https://example.com")
                .setLogo(R.drawable.ic_launcher_background)
                .setAlwaysShowSignInMethodScreen(true)
                .build();

        startActivityForResult(intent, AUTHUI_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AUTHUI_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Log.d(SignInUpActivity.class.getSimpleName(), "onActivityResult: " + user.getEmail());
                if (user.getMetadata().getCreationTimestamp() == user.getMetadata().getLastSignInTimestamp()) {
                    Toast.makeText(this, "Welcome new User", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Welcome back again", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
            } else {
                IdpResponse response = IdpResponse.fromResultIntent(data);
                if (response == null) {
                    Log.d(SignInUpActivity.class.getSimpleName(), "onActivityResult: the user has cancelled the sign in request");
                } else {
                    Log.d(SignInUpActivity.class.getSimpleName(), "onActivityResult: ", response.getError());
                }
            }
        }
    }
}
