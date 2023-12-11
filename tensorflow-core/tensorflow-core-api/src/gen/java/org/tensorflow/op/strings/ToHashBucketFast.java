/* Copyright 2018-2023 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
=======================================================================*/

// This class has been generated, DO NOT EDIT!

package org.tensorflow.op.strings;

import java.util.Arrays;
import org.tensorflow.GraphOperation;
import org.tensorflow.Operand;
import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.RawOp;
import org.tensorflow.op.RawOpInputs;
import org.tensorflow.op.Scope;
import org.tensorflow.op.annotation.Endpoint;
import org.tensorflow.op.annotation.OpInputsMetadata;
import org.tensorflow.op.annotation.OpMetadata;
import org.tensorflow.op.annotation.Operator;
import org.tensorflow.types.TInt64;
import org.tensorflow.types.TString;

/**
 * Converts each string in the input Tensor to its hash mod by a number of buckets.
 * The hash function is deterministic on the content of the string within the
 * process and will never change. However, it is not suitable for cryptography.
 * This function may be used when CPU time is scarce and inputs are trusted or
 * unimportant. There is a risk of adversaries constructing inputs that all hash
 * to the same bucket. To prevent this problem, use a strong hash function with
 * {@code tf.string_to_hash_bucket_strong}.
 * <p>Examples:
 * <blockquote>
 * <blockquote>
 * <blockquote>
 * <p>tf.strings.to_hash_bucket_fast([&quot;Hello&quot;, &quot;TensorFlow&quot;, &quot;2.x&quot;], 3).numpy()
 * array([0, 2, 2])
 * </blockquote>
 * </blockquote>
 * </blockquote>
 */
@OpMetadata(
    opType = ToHashBucketFast.OP_NAME,
    inputsClass = ToHashBucketFast.Inputs.class
)
@Operator(
    group = "strings"
)
public final class ToHashBucketFast extends RawOp implements Operand<TInt64> {
  /**
   * The name of this op, as known by TensorFlow core engine
   */
  public static final String OP_NAME = "StringToHashBucketFast";

  private Output<TInt64> output;

  public ToHashBucketFast(Operation operation) {
    super(operation, OP_NAME);
    int outputIdx = 0;
    output = operation.output(outputIdx++);
  }

  /**
   * Factory method to create a class wrapping a new StringToHashBucketFast operation.
   *
   * @param scope current scope
   * @param input The strings to assign a hash bucket.
   * @param numBuckets The number of buckets.
   * @return a new instance of ToHashBucketFast
   */
  @Endpoint(
      describeByClass = true
  )
  public static ToHashBucketFast create(Scope scope, Operand<TString> input, Long numBuckets) {
    OperationBuilder opBuilder = scope.opBuilder(OP_NAME, "ToHashBucketFast");
    opBuilder.addInput(input.asOutput());
    opBuilder.setAttr("num_buckets", numBuckets);
    return new ToHashBucketFast(opBuilder.build());
  }

  /**
   * Gets output.
   * A Tensor of the same shape as the input {@code string_tensor}.
   * @return output.
   */
  public Output<TInt64> output() {
    return output;
  }

  @Override
  public Output<TInt64> asOutput() {
    return output;
  }

  @OpInputsMetadata(
      outputsClass = ToHashBucketFast.class
  )
  public static class Inputs extends RawOpInputs<ToHashBucketFast> {
    /**
     * The strings to assign a hash bucket.
     */
    public final Operand<TString> input;

    /**
     * The number of buckets.
     */
    public final long numBuckets;

    public Inputs(GraphOperation op) {
      super(new ToHashBucketFast(op), op, Arrays.asList("num_buckets"));
      int inputIndex = 0;
      input = (Operand<TString>) op.input(inputIndex++);
      numBuckets = op.attributes().getAttrInt("num_buckets");
    }
  }
}
