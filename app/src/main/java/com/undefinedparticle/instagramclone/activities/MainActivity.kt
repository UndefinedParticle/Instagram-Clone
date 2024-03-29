package com.undefinedparticle.instagramclone.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.undefinedparticle.instagramclone.R
import com.undefinedparticle.instagramclone.databinding.ActivityMainBinding
import com.undefinedparticle.instagramclone.fragments.AddBottomSheetDialogFragment
import com.undefinedparticle.instagramclone.fragments.ExploreFragment
import com.undefinedparticle.instagramclone.fragments.HomeFragment
import com.undefinedparticle.instagramclone.fragments.NotificationFragment
import com.undefinedparticle.instagramclone.fragments.ProfileFragment
import com.undefinedparticle.instagramclone.fragments.ReelsFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


        binding.addButton.setOnClickListener {

            val addBottomSheetDialogFragment = AddBottomSheetDialogFragment()
            addBottomSheetDialogFragment.show(supportFragmentManager, "addBottomSheetDialogFragment")

        }

        replaceFragment(HomeFragment())
        binding.bottomNavView.setOnNavigationItemSelectedListener {item ->

            when(item.itemId){
                R.id.homeFragment ->{

                    replaceFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.exploreFragment ->{

                    replaceFragment(ExploreFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                /*R.id.addFragment ->{

                    replaceFragment(AddBottomSheetDialogFragment())
                    return@setOnNavigationItemSelectedListener true
                }*/
                R.id.reelsFragment ->{

                    replaceFragment(ReelsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profileFragment ->{

                    replaceFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }


        }

    }

    // Function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if(currentFragment is HomeFragment){
            finish()
        }else{
            binding.bottomNavView.selectedItemId = R.id.homeFragment
        }

    }

}