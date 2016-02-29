package mobi.fastcard.helpers.image;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by DELL on 2/15/2016.
 */
public class ImageLoader {
    public static void LoadImage(Activity activity, String URL, ImageView imageView)
    {
        Glide.with(activity)
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void LoadImage(Context context, String URL, ImageView imageView)
    {
        Glide.with(context)
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void LoadImage(Fragment fragment, String URL, ImageView imageView)
    {
        Glide.with(fragment)
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
