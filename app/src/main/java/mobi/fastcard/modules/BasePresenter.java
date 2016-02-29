package mobi.fastcard.modules;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DELL on 2/15/2016.
 */
public class BasePresenter<T> {
    protected T iView;
    public void AttachView(T view) {
        iView = view;
    }
    public void unSubscribeSubscription()
    {

    }
    public void DetachView() {
        this.iView = null;
        unSubscribeSubscription();
    }

    public <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
