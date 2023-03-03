package com.example.myshop.presentation.secondScreen

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myshop.databinding.FragmentProfileBinding
import com.example.myshop.presentation.startScreen.StartActivity
import java.io.IOException


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.textView6.setOnClickListener{
            getPhoto()
        }

        binding.imageView15.setOnClickListener {
            startActivity(Intent(activity, StartActivity::class.java))
            activity?.finish()
        }

        binding.textView14.setOnClickListener {
            startActivity(Intent(activity, StartActivity::class.java))
            activity?.finish()
        }

        return binding.root
    }

    fun getPhoto() {
        val i = Intent(
            Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(i, 1)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == AppCompatActivity.RESULT_OK && null != data) {

            if (Build.VERSION.SDK_INT >= 29) {
                val selectedImage: Uri? = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val cursor =
                    context?.contentResolver?.query(
                        selectedImage!!,
                        filePathColumn,
                        null,
                        null,
                        null
                    )!!
                cursor.moveToFirst()
                cursor.close()

                try {
                    context?.contentResolver?.openFileDescriptor(selectedImage!!, "r")
                        .use { pfd ->
                        if (pfd != null) {
                            binding.imageView1.setImageBitmap(BitmapFactory
                                .decodeFileDescriptor(pfd.fileDescriptor))
                        }
                    }
                } catch (_: IOException) {
                }
            } else {
                val selectedImage: Uri? = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val cursor =
                    context?.contentResolver?.query(
                        selectedImage!!,
                        filePathColumn,
                        null,
                        null,
                        null
                    )!!
                cursor.moveToFirst()
                val columnIndex: Int = cursor.getColumnIndex(filePathColumn[0])
                val picturePath: String = cursor.getString(columnIndex)
                cursor.close()
                binding.imageView1.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            }

        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}