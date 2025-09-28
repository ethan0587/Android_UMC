package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentAlbumBinding

class AlbumFragment : Fragment() {
    private lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding 먼저 초기화
        binding = FragmentAlbumBinding.inflate(inflater, container, false)

        // arguments 처리
        arguments?.let {
            val title = it.getString("title")
            val singer = it.getString("singer")
            binding.albumMusicTitleTv.text = title
            binding.albumSingerNameTv.text = singer
        }

        // 뒤로가기 버튼 클릭 이벤트
        binding.albumBackIv.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, HomeFragment())
                .commit()
        }

        return binding.root
    }
}
