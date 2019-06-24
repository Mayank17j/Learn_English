package com.example.language;

public class Word {
    private String mDefaultTranslation;
    private String mHindiTranslation;
    private int mImageResourceId=NO_IMAGE_PROVIDED; //Default value of NO_IMAGE_PROVIDED
    private int mAudioResourceId;

    //for no image visible
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation,String hindiTranslation){
        mDefaultTranslation =defaultTranslation;
        mHindiTranslation=hindiTranslation;
    }
    public Word(String defaultTranslation,String hindiTranslation,int imageResourceId,int audioResourceId){
        mDefaultTranslation=defaultTranslation;
        mHindiTranslation=hindiTranslation;
        mImageResourceId=imageResourceId;
        mAudioResourceId=audioResourceId;
    }

    public Word(String defaultTranslation,String hindiTranslation,int imageResourceId){
        mDefaultTranslation=defaultTranslation;
        mHindiTranslation=hindiTranslation;
        mImageResourceId=imageResourceId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getHindiTranslation(){
        return mHindiTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    //Return whether or not there is an image for this word.
    public boolean hasImage(){
        return  mImageResourceId!=NO_IMAGE_PROVIDED;
    }
}
