package com.example.rickandmortynew.presentation.ui.dialogs.character.image

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.rickandmortynew.databinding.DialogCharacterImageBinding
import com.example.rickandmortynew.presentation.base.BaseDialog
import com.example.rickandmortynew.presentation.ui.fragments.detail.CharacterDetailFragmentArgs

class CharacterImageDialog : BaseDialog<DialogCharacterImageBinding>() {

    override val binding: DialogCharacterImageBinding by viewBinding()
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    override fun initialize() {
        binding.imageCharacterPhotoDetail.load(args.image)
    }
}