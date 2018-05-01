package com.example.mengh.mhwheel.news.bean;

import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

public class NewsSearchSuggestion implements SearchSuggestion{
    private String NewsName;
    private boolean IsHistory = false;

    public NewsSearchSuggestion(Parcel newsName) {
        NewsName = newsName.readString();
    }

    public NewsSearchSuggestion(String newsName) {
        NewsName = newsName;
    }

    public boolean isHistory() {
        return IsHistory;
    }

    public void setHistory(boolean history) {
        IsHistory = history;
    }

    @Override
    public String getBody() {
        return NewsName;
    }
    public static final Creator<NewsSearchSuggestion> CREATOR = new Creator<NewsSearchSuggestion>() {
        @Override
        public NewsSearchSuggestion createFromParcel(Parcel in) {
            return new NewsSearchSuggestion(in);
        }

        @Override
        public NewsSearchSuggestion[] newArray(int size) {
            return new NewsSearchSuggestion[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(NewsName);
        dest.writeInt(IsHistory ? 1 : 0);
    }
}
