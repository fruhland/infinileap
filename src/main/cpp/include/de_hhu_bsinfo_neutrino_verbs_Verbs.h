/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class de_hhu_bsinfo_neutrino_verbs_Verbs */

#ifndef _Included_de_hhu_bsinfo_neutrino_verbs_Verbs
#define _Included_de_hhu_bsinfo_neutrino_verbs_Verbs
#ifdef __cplusplus
extern "C" {
#endif
#undef de_hhu_bsinfo_neutrino_verbs_Verbs_DEFAULT_POOL_SIZE
#define de_hhu_bsinfo_neutrino_verbs_Verbs_DEFAULT_POOL_SIZE 1024L
/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    getNumDevices
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_getNumDevices
  (JNIEnv *, jclass);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    getDeviceName
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_getDeviceName
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    openDevice
 * Signature: (IJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_openDevice
  (JNIEnv *, jclass, jint, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    closeDevice
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_closeDevice
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    queryDevice
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_queryDevice
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    queryPort
 * Signature: (JJIJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_queryPort
  (JNIEnv *, jclass, jlong, jlong, jint, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    getAsyncEvent
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_getAsyncEvent
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    acknowledgeAsyncEvent
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_acknowledgeAsyncEvent
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    allocateProtectionDomain
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_allocateProtectionDomain
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    deallocateProtectionDomain
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_deallocateProtectionDomain
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    allocateDeviceMemory
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_allocateDeviceMemory
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    registerDeviceMemoryAsMemoryRegion
 * Signature: (JJJJIJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_registerDeviceMemoryAsMemoryRegion
  (JNIEnv *, jclass, jlong, jlong, jlong, jlong, jint, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    copyToDeviceMemory
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_copyToDeviceMemory
  (JNIEnv *, jclass, jlong, jlong, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    copyFromDeviceMemory
 * Signature: (JJJJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_copyFromDeviceMemory
  (JNIEnv *, jclass, jlong, jlong, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    freeDeviceMemory
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_freeDeviceMemory
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    registerMemoryRegion
 * Signature: (JJJIJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_registerMemoryRegion
  (JNIEnv *, jclass, jlong, jlong, jlong, jint, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    allocateNullMemoryRegion
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_allocateNullMemoryRegion
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    deregisterMemoryRegion
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_deregisterMemoryRegion
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    createAddressHandle
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_createAddressHandle
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    destroyAddressHandle
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_destroyAddressHandle
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    createCompletionChannel
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_createCompletionChannel
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    getCompletionEvent
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_getCompletionEvent
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    destroyCompletionChannel
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_destroyCompletionChannel
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    createCompletionQueue
 * Signature: (JIJJIJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_createCompletionQueue
  (JNIEnv *, jclass, jlong, jint, jlong, jlong, jint, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    pollCompletionQueue
 * Signature: (JIJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_pollCompletionQueue
  (JNIEnv *, jclass, jlong, jint, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    requestNotification
 * Signature: (JIJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_requestNotification
  (JNIEnv *, jclass, jlong, jint, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    acknowledgeCompletionEvents
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_acknowledgeCompletionEvents
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    destroyCompletionQueue
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_destroyCompletionQueue
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    postSendWorkRequest
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_postSendWorkRequest
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    postReceiveWorkRequest
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_postReceiveWorkRequest
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    createSharedReceiveQueue
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_createSharedReceiveQueue
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    createQueuePair
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_createQueuePair
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    modifyQueuePair
 * Signature: (JJIJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_modifyQueuePair
  (JNIEnv *, jclass, jlong, jlong, jint, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    queryQueuePair
 * Signature: (JJIJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_queryQueuePair
  (JNIEnv *, jclass, jlong, jlong, jint, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    destroyQueuePair
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_destroyQueuePair
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    queryExtendedDevice
 * Signature: (JJJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_queryExtendedDevice
  (JNIEnv *, jclass, jlong, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    createExtendedCompletionQueue
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_createExtendedCompletionQueue
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    extendedCompletionQueueToCompletionQueue
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_extendedCompletionQueueToCompletionQueue
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    startPoll
 * Signature: (JJJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_startPoll
  (JNIEnv *, jclass, jlong, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    nextPoll
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_nextPoll
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    endPoll
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_endPoll
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readOpCode
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readOpCode
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readVendorError
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readVendorError
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readByteCount
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readByteCount
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readImmediateData
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readImmediateData
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readInvalidatedRemoteKey
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readInvalidatedRemoteKey
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readQueuePairNumber
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readQueuePairNumber
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readSourceQueuePair
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readSourceQueuePair
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readWorkCompletionFlags
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readWorkCompletionFlags
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readSourceLocalId
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readSourceLocalId
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readServiceLevel
 * Signature: (J)B
 */
JNIEXPORT jbyte JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readServiceLevel
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readPathBits
 * Signature: (J)B
 */
JNIEXPORT jbyte JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readPathBits
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readCompletionTimestamp
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readCompletionTimestamp
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readCompletionWallClockNanoseconds
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readCompletionWallClockNanoseconds
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readCVLan
 * Signature: (J)S
 */
JNIEXPORT jshort JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readCVLan
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readFlowTag
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readFlowTag
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    readTagMatchingInfo
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_readTagMatchingInfo
  (JNIEnv *, jclass, jlong, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    benchmarkDummyMethod1
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_benchmarkDummyMethod1
  (JNIEnv *, jclass, jlong);

/*
 * Class:     de_hhu_bsinfo_neutrino_verbs_Verbs
 * Method:    benchmarkDummyMethod2
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_hhu_bsinfo_neutrino_verbs_Verbs_benchmarkDummyMethod2
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
