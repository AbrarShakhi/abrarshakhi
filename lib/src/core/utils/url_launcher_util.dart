import 'package:flutter/foundation.dart';
import 'package:url_launcher/url_launcher.dart';

abstract final class UrlLauncherUtil {
  static Future<void> open(String url) async {
    final uri = Uri.tryParse(url);

    if (!await launchUrl(uri, mode: LaunchMode.externalApplication)) {
      debugPrint('Could not launch $url');
    }
  }
}
