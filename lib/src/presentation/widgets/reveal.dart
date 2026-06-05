import 'package:flutter/material.dart';
import 'package:visibility_detector/visibility_detector.dart';

/// Fades + lifts its [child] into view the first time it scrolls onto screen —
/// the quiet, restrained entrance you see across claude.ai.
///
/// The child is always present in the tree (just transparent until revealed),
/// so it stays accessible and testable. Use [delay] to stagger siblings.
class Reveal extends StatefulWidget {
  const Reveal({
    super.key,
    required this.child,
    this.delay = Duration.zero,
    this.offsetY = 24,
    this.duration = const Duration(milliseconds: 650),
  });

  final Widget child;
  final Duration delay;

  /// How far (in logical px) the child travels up as it fades in.
  final double offsetY;
  final Duration duration;

  @override
  State<Reveal> createState() => _RevealState();
}

class _RevealState extends State<Reveal> with SingleTickerProviderStateMixin {
  static int _instances = 0;
  late final Key _detectorKey = ValueKey('reveal-${_instances++}');

  late final AnimationController _controller = AnimationController(
    vsync: this,
    duration: widget.duration,
  );
  late final Animation<double> _curve = CurvedAnimation(
    parent: _controller,
    curve: Curves.easeOutCubic,
  );

  bool _revealed = false;

  void _onVisibility(VisibilityInfo info) {
    if (_revealed || info.visibleFraction < 0.08) return;
    _revealed = true;
    if (widget.delay == Duration.zero) {
      _controller.forward();
    } else {
      Future.delayed(widget.delay, () {
        if (mounted) _controller.forward();
      });
    }
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return VisibilityDetector(
      key: _detectorKey,
      onVisibilityChanged: _onVisibility,
      child: AnimatedBuilder(
        animation: _curve,
        builder: (context, child) => Opacity(
          opacity: _curve.value,
          child: Transform.translate(
            offset: Offset(0, widget.offsetY * (1 - _curve.value)),
            child: child,
          ),
        ),
        child: widget.child,
      ),
    );
  }
}
