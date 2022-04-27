package kr.hs.dgsw.sport_recruit.ui.activity

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.sport_recruit.R
import kr.hs.dgsw.sport_recruit.base.BaseActivity
import kr.hs.dgsw.sport_recruit.databinding.ActivityRegisterBinding
import kr.hs.dgsw.sport_recruit.util.isNotNullOrEmpty
import kr.hs.dgsw.sport_recruit.util.testLog
import kr.hs.dgsw.sport_recruit.util.toast
import kr.hs.dgsw.sport_recruit.viewmodel.RegisterViewModel

@AndroidEntryPoint
class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {
    override val mViewModel: RegisterViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_register

    override fun observeViewModel() {
        with(mViewModel) {
            onSuccessRegister.observe(this@RegisterActivity, Observer {
                toast("회원가입 성공!")
                finish()
            })

            onErrorEvent.observe(this@RegisterActivity, Observer {
                toast("${it.message}")
                testLog("$it")
            })
        }
    }

    fun onClickRegisterBtn() {
        with(mViewModel) {
            testLog(
                "${id.value} ${pw.value} ${name.value} ${name.value} ${profile.value} ${grade.value} ${room.value} ${number.value}")

            if (isNotNullOrEmpty(id.value) && isNotNullOrEmpty(pw.value) && isNotNullOrEmpty(name.value) && isNotNullOrEmpty(
                    name.value) && isNotNullOrEmpty(grade.value) && isNotNullOrEmpty(
                    room.value) && isNotNullOrEmpty(number.value)
            ) {
                register()
            } else {
                toast("모두 입력 후 회원가입 버튼을 눌러주세요.")
            }
        }
    }
}