package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class ViewPageMessengerAdapter extends FragmentPagerAdapter
{

    public ViewPageMessengerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if(position==0)
        {
            return new chat_Fragment();
        }
        else if(position==1)
        {
            return new status_Fragment();
        }
        else if(position==2)
        {
            return new calls_Fragment();
        }
        else if(position==3)
        {
            return new fav_Fragment();
        }
        else if(position==4)
        {
            return new stared_Fragment();
        }
        else
        {
            return new download_Fragment();
        }
    }

    @Override
    public int getCount()
    {
        return 6;
    }

    //getpagetitle
    @Override
    public CharSequence getPageTitle(int position)
    {
        if(position==0)
        {
            return "Chats";
        }
        else if (position==1)
        {
            return "Status";
        }
        else if(position==2)
        {
            return "Calls";
        }
        else if (position==3)
        {
            return "Favourites";
        }
        else if(position==4)
        {
            return "Stared msges";
        }
        else
        {
            return "Download";
        }
    }
}

