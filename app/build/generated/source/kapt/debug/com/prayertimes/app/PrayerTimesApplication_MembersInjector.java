package com.prayertimes.app;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class PrayerTimesApplication_MembersInjector implements MembersInjector<PrayerTimesApplication> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public PrayerTimesApplication_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<PrayerTimesApplication> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new PrayerTimesApplication_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(PrayerTimesApplication instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.prayertimes.app.PrayerTimesApplication.workerFactory")
  public static void injectWorkerFactory(PrayerTimesApplication instance,
      HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
