package kr.co.hanbit.week6_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.hanbit.week6_1.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentEmailBinding.inflate(layoutInflater).root
    }
}