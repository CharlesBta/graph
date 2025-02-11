package com.cab.graph;

import lombok.NonNull;

public interface IView {
    void setModel(@NonNull final IModel model);
    void setController(@NonNull final IController controller);
}
