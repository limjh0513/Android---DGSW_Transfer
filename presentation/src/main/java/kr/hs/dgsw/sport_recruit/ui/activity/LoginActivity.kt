package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseActivity
import kr.hs.dgsw.sport_recruit.databinding.ActivityLoginBinding
import kr.hs.dgsw.sport_recruit.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val mViewModel: LoginViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observeViewModel() {
        with(mViewModel){

        }
    }
}