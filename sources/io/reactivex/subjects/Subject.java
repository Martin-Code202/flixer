package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
}
