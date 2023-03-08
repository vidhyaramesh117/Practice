package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> frag_list= new ArrayList<>();
    private final List<String> frag_title_list = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frag_list.get(position);
    }


    @Override
    public int getCount() {
        return frag_list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return frag_title_list.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        frag_list.add(fragment);
        frag_title_list.add(title);
    }
}















//    @Override
//    public Fragment getItem(int position)
//    {
//        if(position==0)
//        {
//            return new chat_Fragment();
//        }
//        else if(position==1)
//        {
//            return new status_Fragment();
//        }
//        else if(position==2)
//        {
//            return new calls_Fragment();
//        }
//        else if(position==3)
//        {
//            return new fav_Fragment();
//        }
//        else if(position==4)
//        {
//            return new stared_Fragment();
//        }
//        else
//        {
//            return new download_Fragment();
//        }
//    }
//
//    @Override
//    public int getCount()
//    {
//        return 6;
//    }
//
//    //getpagetitle
//    @Override
//    public CharSequence getPageTitle(int position)
//    {
//        if(position==0)
//        {
//            return "Chats";
//        }
//        else if (position==1)
//        {
//            return "Status";
//        }
//        else if(position==2)
//        {
//            return "Calls";
//        }
//        else if (position==3)
//        {
//            return "Favourites";
//        }
//        else if(position==4)
//        {
//            return "Stared msges";
//        }
//        else
//        {
//            return "Download";
//        }
//    }
//}
