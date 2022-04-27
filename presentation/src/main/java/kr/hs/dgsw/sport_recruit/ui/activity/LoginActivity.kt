package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.data.util.PreferenceManager
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseActivity
import kr.hs.dgsw.sport_recruit.databinding.ActivityLoginBinding
import kr.hs.dgsw.sport_recruit.util.*
import kr.hs.dgsw.sport_recruit.viewmodel.LoginViewModel

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val mViewModel: LoginViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun observeViewModel() {
        with(mViewModel) {
            onSuccessLogin.observe(this@LoginActivity, Observer {
                PreferenceManager.setUser(this@LoginActivity, it)
                this@LoginActivity.startActivityAndFinish(MainActivity::class.java)
            })

            onErrorEvent.observe(this@LoginActivity, Observer {
                toast(it.message.toString())
            })
        }
    }

    fun onClickLoginBtn() {
        with(mViewModel) {
            testLog("${id.value} ${pw.value}")

            if(isNotNullOrEmpty(id.value) && isNotNullOrEmpty(pw.value)){
                login()
            } else {
                toast("아이디 및 비밀번호를 입력해주세요!")
            }
        }
    }

    fun onClickRegisterBtn() {
        startActivity(RegisterActivity::class.java)
    }
}