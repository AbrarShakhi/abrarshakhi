import 'package:abrarshakhi/src/data/repositories/portfolio_repository_impl.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:visibility_detector/visibility_detector.dart';

import 'package:abrarshakhi/src/app.dart';
import 'package:abrarshakhi/src/data/portfolio_content.dart';

void main() {
  testWidgets('renders the profile name from portfolio content', (
    WidgetTester tester,
  ) async {
    GoogleFonts.config.allowRuntimeFetching = false;
    VisibilityDetectorController.instance.updateInterval = Duration.zero;

    await tester.pumpWidget(
      const PortfolioApp(repository: PortfolioRepositoryImpl()),
    );

    await tester.pump();
    await tester.pump(const Duration(seconds: 1));

    expect(find.text(portfolioContent.profile.name), findsWidgets);
  });
}
