/* Copyright 2018 The TensorFlow Authors. All Rights Reserved.

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

package org.tensorflow.op.core;

import org.tensorflow.Operation;
import org.tensorflow.OperationBuilder;
import org.tensorflow.Output;
import org.tensorflow.op.PrimitiveOp;
import org.tensorflow.op.Scope;
import org.tensorflow.types.TFloat32;

/**
 * Retrieve Momentum embedding parameters with debug support.
 * <p>
 * An op that retrieves optimization parameters from embedding to host
 * memory. Must be preceded by a ConfigureTPUEmbeddingHost op that sets up
 * the correct embedding table configuration. For example, this op is
 * used to retrieve updated parameters before saving a checkpoint.
 */
public final class RetrieveTPUEmbeddingMomentumParametersGradAccumDebug extends PrimitiveOp {
  
  /**
   * Optional attributes for {@link org.tensorflow.op.core.RetrieveTPUEmbeddingMomentumParametersGradAccumDebug}
   */
  public static class Options {
    
    /**
     * @param tableId 
     */
    public Options tableId(Long tableId) {
      this.tableId = tableId;
      return this;
    }
    
    /**
     * @param tableName 
     */
    public Options tableName(String tableName) {
      this.tableName = tableName;
      return this;
    }
    
    private Long tableId;
    private String tableName;
    
    private Options() {
    }
  }
  
  /**
   * Factory method to create a class wrapping a new RetrieveTPUEmbeddingMomentumParametersGradAccumDebug operation.
   * 
   * @param scope current scope
   * @param numShards 
   * @param shardId 
   * @param options carries optional attributes values
   * @return a new instance of RetrieveTPUEmbeddingMomentumParametersGradAccumDebug
   */
  public static RetrieveTPUEmbeddingMomentumParametersGradAccumDebug create(Scope scope, Long numShards, Long shardId, Options... options) {
    OperationBuilder opBuilder = scope.env().opBuilder("RetrieveTPUEmbeddingMomentumParametersGradAccumDebug", scope.makeOpName("RetrieveTPUEmbeddingMomentumParametersGradAccumDebug"));
    opBuilder = scope.applyControlDependencies(opBuilder);
    opBuilder.setAttr("num_shards", numShards);
    opBuilder.setAttr("shard_id", shardId);
    if (options != null) {
      for (Options opts : options) {
        if (opts.tableId != null) {
          opBuilder.setAttr("table_id", opts.tableId);
        }
        if (opts.tableName != null) {
          opBuilder.setAttr("table_name", opts.tableName);
        }
      }
    }
    return new RetrieveTPUEmbeddingMomentumParametersGradAccumDebug(opBuilder.build());
  }
  
  /**
   * @param tableId 
   */
  public static Options tableId(Long tableId) {
    return new Options().tableId(tableId);
  }
  
  /**
   * @param tableName 
   */
  public static Options tableName(String tableName) {
    return new Options().tableName(tableName);
  }
  
  /**
   * Parameter parameters updated by the Momentum optimization algorithm.
   */
  public Output<TFloat32> parameters() {
    return parameters;
  }
  
  /**
   * Parameter momenta updated by the Momentum optimization algorithm.
   */
  public Output<TFloat32> momenta() {
    return momenta;
  }
  
  /**
   * Parameter gradient_accumulators updated by the Momentum optimization algorithm.
   */
  public Output<TFloat32> gradientAccumulators() {
    return gradientAccumulators;
  }
  
  private Output<TFloat32> parameters;
  private Output<TFloat32> momenta;
  private Output<TFloat32> gradientAccumulators;
  
  private RetrieveTPUEmbeddingMomentumParametersGradAccumDebug(Operation operation) {
    super(operation);
    int outputIdx = 0;
    parameters = operation.output(outputIdx++);
    momenta = operation.output(outputIdx++);
    gradientAccumulators = operation.output(outputIdx++);
  }
}
