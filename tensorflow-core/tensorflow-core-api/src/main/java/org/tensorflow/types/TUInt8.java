/*
 *  Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  =======================================================================
 */

package org.tensorflow.types;

import org.tensorflow.DataType;
import org.tensorflow.Tensor;
import org.tensorflow.internal.buffer.TensorBuffers;
import org.tensorflow.internal.c_api.TF_Tensor;
import org.tensorflow.tools.Shape;
import org.tensorflow.tools.buffer.ByteDataBuffer;
import org.tensorflow.tools.ndarray.ByteNdArray;
import org.tensorflow.tools.ndarray.NdArray;
import org.tensorflow.tools.ndarray.impl.dense.ByteDenseNdArray;
import org.tensorflow.types.family.TNumber;

/**
 * 8-bits unsigned integer type.
 */
public interface TUInt8 extends ByteNdArray, TNumber {

  /** Type metadata */
  DataType<TUInt8> DTYPE = DataType.create("UINT8", 4, 1, TUInt8Impl::mapTensor);

  /**
   * Allocates a new tensor for storing a byte scalar.
   *
   * @param value scalar value to store in the new tensor
   * @return the new tensor
   */
  static Tensor<TUInt8> scalarOf(byte value) {
    Tensor<TUInt8> t = ofShape();
    t.data().setByte(value);
    return t;
  }

  /**
   * Allocates a new tensor for storing a byte vector.
   *
   * @param values values to store in the new tensor
   * @return the new tensor
   */
  static Tensor<TUInt8> vectorOf(byte... values) {
    Tensor<TUInt8> t = ofShape(values.length);
    t.data().write(values);
    return t;
  }

  /**
   * Allocates a new tensor of the given shape.
   *
   * @param shape shape of the tensor to allocate
   * @return the new tensor
   */
  static Tensor<TUInt8> ofShape(Shape shape) {
    return Tensor.allocate(DTYPE, shape);
  }

  /**
   * Allocates a new tensor of the given shape.
   *
   * <p>Invoking {@code ofShape(x, y, z)} is equivalent to {@code ofShape(Shape.make(x, y, z))}
   *
   * @param dimensionSizes dimension sizes that defines the shape of the tensor to allocate
   * @return the new tensor
   */
  static Tensor<TUInt8> ofShape(long... dimensionSizes) {
    return Tensor.allocate(DTYPE, Shape.make(dimensionSizes));
  }

  /**
   * Allocates a new tensor which is a copy of a given array.
   *
   * <p>The tensor will have the same shape as the source array and its data will be copied.
   *
   * @param src the source array giving the shape and data to the new tensor
   * @return the new tensor
   */
  static Tensor<TUInt8> copyOf(NdArray<Byte> src) {
    Tensor<TUInt8> t = Tensor.allocate(DTYPE, src.shape());
    src.copyTo(t.data());
    return t;
  }
}

class TUInt8Impl extends ByteDenseNdArray implements TUInt8 {

  static TUInt8 mapTensor(TF_Tensor nativeTensor, Shape shape) {
    return new TUInt8Impl(TensorBuffers.toBytes(nativeTensor), shape);
  }

  private TUInt8Impl(ByteDataBuffer buffer, Shape shape) {
    super(buffer, shape);
  }
}
