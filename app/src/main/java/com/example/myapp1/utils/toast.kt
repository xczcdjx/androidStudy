package com.example.myapp1.utils

import android.content.Context
import android.widget.Toast

inline fun Context.toast(text: CharSequence) =
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()