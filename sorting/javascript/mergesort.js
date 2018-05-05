"use strict";

/**
 *   MergeSort implemented in Javascript
 *
 *   Time complexity is O(n log(n))
 *
 *
 */

function mergeSort(input) {
  var helper = new Array(input.length);
  
  doMergeSort(input,helper,0,input.length -1);
}

function doMergeSort(input,helper,low,high) {
  if (high <= low) {
    return;
  }
  
  var middle = Math.floor((low + high) / 2);
  
  doMergeSort(input,helper,0,middle);
  doMergeSort(input,helper,middle + 1,high);
  
  merge(input,helper,low,middle,high);
}

function merge(input,helper,low,middle,high) {
  // Copy the original array to the helper array 
  for(let j = 0; j < input.length; j++) {
    helper[j] = input[j];
  }
  
  var helperLeft = low;
  var helperRight = middle + 1;
  
  var current = low;
  
  while(helperLeft <= middle && helperRight <= high) {
    if (helper[helperLeft] <= helper[helperRight]) {
      input[current] = helper[helperLeft];
      helperLeft++;
    }
    else {
      input[current] = helper[helperRight];
      helperRight++;
    }
    
    current++;
  }
  
  // And now remaining elements are copied
  var remaining = middle - helperLeft;
  
  for(let j = 0; j <= remaining; j++) {
    input[current + j] = helper[helperLeft + j];
  }
}