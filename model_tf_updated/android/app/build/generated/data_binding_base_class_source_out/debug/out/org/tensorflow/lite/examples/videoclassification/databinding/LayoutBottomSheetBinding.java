// Generated by view binder compiler. Do not edit!
package org.tensorflow.lite.examples.videoclassification.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.tensorflow.lite.examples.videoclassification.R;

public final class LayoutBottomSheetBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView bottomSheetArrow;

  @NonNull
  public final LinearLayout bottomSheetLayout;

  @NonNull
  public final Button btnClearModelState;

  @NonNull
  public final LinearLayout gestureLayout;

  @NonNull
  public final TextView inference;

  @NonNull
  public final TextView inferenceInfo;

  @NonNull
  public final TextView inputFps;

  @NonNull
  public final TextView inputFpsInfo;

  @NonNull
  public final TextView inputSize;

  @NonNull
  public final TextView inputSizeInfo;

  @NonNull
  public final LinearLayout llChangeThreads;

  @NonNull
  public final ImageView minus;

  @NonNull
  public final ImageView plus;

  @NonNull
  public final Spinner spnSelectModel;

  @NonNull
  public final TextView threads;

  @NonNull
  public final TextView tvDetectedItem0;

  @NonNull
  public final TextView tvDetectedItem0Value;

  @NonNull
  public final TextView tvDetectedItem1;

  @NonNull
  public final TextView tvDetectedItem1Value;

  @NonNull
  public final TextView tvDetectedItem2;

  @NonNull
  public final TextView tvDetectedItem2Value;

  private LayoutBottomSheetBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView bottomSheetArrow, @NonNull LinearLayout bottomSheetLayout,
      @NonNull Button btnClearModelState, @NonNull LinearLayout gestureLayout,
      @NonNull TextView inference, @NonNull TextView inferenceInfo, @NonNull TextView inputFps,
      @NonNull TextView inputFpsInfo, @NonNull TextView inputSize, @NonNull TextView inputSizeInfo,
      @NonNull LinearLayout llChangeThreads, @NonNull ImageView minus, @NonNull ImageView plus,
      @NonNull Spinner spnSelectModel, @NonNull TextView threads, @NonNull TextView tvDetectedItem0,
      @NonNull TextView tvDetectedItem0Value, @NonNull TextView tvDetectedItem1,
      @NonNull TextView tvDetectedItem1Value, @NonNull TextView tvDetectedItem2,
      @NonNull TextView tvDetectedItem2Value) {
    this.rootView = rootView;
    this.bottomSheetArrow = bottomSheetArrow;
    this.bottomSheetLayout = bottomSheetLayout;
    this.btnClearModelState = btnClearModelState;
    this.gestureLayout = gestureLayout;
    this.inference = inference;
    this.inferenceInfo = inferenceInfo;
    this.inputFps = inputFps;
    this.inputFpsInfo = inputFpsInfo;
    this.inputSize = inputSize;
    this.inputSizeInfo = inputSizeInfo;
    this.llChangeThreads = llChangeThreads;
    this.minus = minus;
    this.plus = plus;
    this.spnSelectModel = spnSelectModel;
    this.threads = threads;
    this.tvDetectedItem0 = tvDetectedItem0;
    this.tvDetectedItem0Value = tvDetectedItem0Value;
    this.tvDetectedItem1 = tvDetectedItem1;
    this.tvDetectedItem1Value = tvDetectedItem1Value;
    this.tvDetectedItem2 = tvDetectedItem2;
    this.tvDetectedItem2Value = tvDetectedItem2Value;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutBottomSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_bottom_sheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutBottomSheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom_sheet_arrow;
      ImageView bottomSheetArrow = ViewBindings.findChildViewById(rootView, id);
      if (bottomSheetArrow == null) {
        break missingId;
      }

      LinearLayout bottomSheetLayout = (LinearLayout) rootView;

      id = R.id.btnClearModelState;
      Button btnClearModelState = ViewBindings.findChildViewById(rootView, id);
      if (btnClearModelState == null) {
        break missingId;
      }

      id = R.id.gesture_layout;
      LinearLayout gestureLayout = ViewBindings.findChildViewById(rootView, id);
      if (gestureLayout == null) {
        break missingId;
      }

      id = R.id.inference;
      TextView inference = ViewBindings.findChildViewById(rootView, id);
      if (inference == null) {
        break missingId;
      }

      id = R.id.inference_info;
      TextView inferenceInfo = ViewBindings.findChildViewById(rootView, id);
      if (inferenceInfo == null) {
        break missingId;
      }

      id = R.id.input_fps;
      TextView inputFps = ViewBindings.findChildViewById(rootView, id);
      if (inputFps == null) {
        break missingId;
      }

      id = R.id.input_fps_info;
      TextView inputFpsInfo = ViewBindings.findChildViewById(rootView, id);
      if (inputFpsInfo == null) {
        break missingId;
      }

      id = R.id.input_size;
      TextView inputSize = ViewBindings.findChildViewById(rootView, id);
      if (inputSize == null) {
        break missingId;
      }

      id = R.id.input_size_info;
      TextView inputSizeInfo = ViewBindings.findChildViewById(rootView, id);
      if (inputSizeInfo == null) {
        break missingId;
      }

      id = R.id.llChangeThreads;
      LinearLayout llChangeThreads = ViewBindings.findChildViewById(rootView, id);
      if (llChangeThreads == null) {
        break missingId;
      }

      id = R.id.minus;
      ImageView minus = ViewBindings.findChildViewById(rootView, id);
      if (minus == null) {
        break missingId;
      }

      id = R.id.plus;
      ImageView plus = ViewBindings.findChildViewById(rootView, id);
      if (plus == null) {
        break missingId;
      }

      id = R.id.spnSelectModel;
      Spinner spnSelectModel = ViewBindings.findChildViewById(rootView, id);
      if (spnSelectModel == null) {
        break missingId;
      }

      id = R.id.threads;
      TextView threads = ViewBindings.findChildViewById(rootView, id);
      if (threads == null) {
        break missingId;
      }

      id = R.id.tv_detected_item0;
      TextView tvDetectedItem0 = ViewBindings.findChildViewById(rootView, id);
      if (tvDetectedItem0 == null) {
        break missingId;
      }

      id = R.id.tv_detected_item0_value;
      TextView tvDetectedItem0Value = ViewBindings.findChildViewById(rootView, id);
      if (tvDetectedItem0Value == null) {
        break missingId;
      }

      id = R.id.tv_detected_item1;
      TextView tvDetectedItem1 = ViewBindings.findChildViewById(rootView, id);
      if (tvDetectedItem1 == null) {
        break missingId;
      }

      id = R.id.tv_detected_item1_value;
      TextView tvDetectedItem1Value = ViewBindings.findChildViewById(rootView, id);
      if (tvDetectedItem1Value == null) {
        break missingId;
      }

      id = R.id.tv_detected_item2;
      TextView tvDetectedItem2 = ViewBindings.findChildViewById(rootView, id);
      if (tvDetectedItem2 == null) {
        break missingId;
      }

      id = R.id.tv_detected_item2_value;
      TextView tvDetectedItem2Value = ViewBindings.findChildViewById(rootView, id);
      if (tvDetectedItem2Value == null) {
        break missingId;
      }

      return new LayoutBottomSheetBinding((LinearLayout) rootView, bottomSheetArrow,
          bottomSheetLayout, btnClearModelState, gestureLayout, inference, inferenceInfo, inputFps,
          inputFpsInfo, inputSize, inputSizeInfo, llChangeThreads, minus, plus, spnSelectModel,
          threads, tvDetectedItem0, tvDetectedItem0Value, tvDetectedItem1, tvDetectedItem1Value,
          tvDetectedItem2, tvDetectedItem2Value);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
