package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseActivity
import kr.hs.dgsw.sport_recruit.databinding.ActivityMainBinding
import kr.hs.dgsw.sport_recruit.ui.fragment.HomeFragment
import kr.hs.dgsw.sport_recruit.ui.fragment.UserFragment
import kr.hs.dgsw.sport_recruit.ui.fragment.WriteFragment
import kr.hs.dgsw.sport_recruit.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val mViewModel: MainViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun observeViewModel() {
        setBottomNavigation()

    }

    fun setBottomNavigation() {
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, HomeFragment()).commit()
        mBinding.bottomNavbar.selectedItemId = R.id.page_home

        mBinding.bottomNavbar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_write -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, WriteFragment()).commit()
                }
                R.id.page_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, HomeFragment()).commit()
                }
                R.id.page_user -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, UserFragment()).commit()
                }
            }
            true
        }
    }
}