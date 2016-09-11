# EPerm
![img](https://jitpack.io/v/aotian16/EPerm.svg)

Permission util for android 6.

# Install

## By jitpack.io

```groovy
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

```groovy
	dependencies {
	        compile 'com.github.aotian16:EPerm:v1.1.0'
	}
```
## Or Download this project and import as a module

# Use

```java
package com.qefee.pj.testpermissionutil;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qefee.pj.eperm.EPerm;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testCall();
            }
        });
    }

    public void testCall() {
        if (EPerm.getCallPhonePerm(this).has()) { // has permission
            callPhone();
        } else {
            if (EPerm.getCallPhonePerm(this).hasReason()) { // reason for permission
                Toast.makeText(MainActivity.this, "no permission to call!", Toast.LENGTH_SHORT).show();
            } else {
                EPerm.getCallPhonePerm(this).request(MY_PERMISSIONS_REQUEST_CALL_PHONE); // request permission
            }
        }
    }

    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + "10086");
        intent.setData(data);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE:
                handleCallPermission(grantResults[0]);
                break;
            default:
                Toast.makeText(MainActivity.this, "unknown request code", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleCallPermission(int grantResult) {
        if (grantResult == PackageManager.PERMISSION_GRANTED) {
            callPhone();
        } else {
            // Permission Denied
            Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }
}
```

# Version

| No.  | Version | Detail              |
| :--: | :-----: | ------------------- |
|  1   |  1.0.0  | First version       |
|  2   |  1.1.0  | add EPerm constants |

# [LICENSE](https://github.com/aotian16/EPerm/blob/master/LICENSE)

MIT