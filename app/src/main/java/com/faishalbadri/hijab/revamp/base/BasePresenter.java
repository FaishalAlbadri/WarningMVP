package com.faishalbadri.hijab.revamp.base;

/**
 * Created by faishal on 10/30/17.
 */

public interface BasePresenter<T> {

  void onAttachView(T view);

  void onDettachView();
}
