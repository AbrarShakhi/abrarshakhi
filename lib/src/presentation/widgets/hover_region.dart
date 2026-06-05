import 'package:flutter/material.dart';

/// Tracks pointer hover and rebuilds [builder] with the current state.
///
/// Centralises the `MouseRegion` + `setState` boilerplate behind the subtle
/// hover transitions (button fills, card lifts) used throughout the site.
class HoverRegion extends StatefulWidget {
  const HoverRegion({
    super.key,
    required this.builder,
    this.cursor = SystemMouseCursors.click,
    this.onTap,
  });

  final ValueWidgetBuilder<bool> builder;
  final MouseCursor cursor;
  final VoidCallback? onTap;

  @override
  State<HoverRegion> createState() => _HoverRegionState();
}

class _HoverRegionState extends State<HoverRegion> {
  bool _hovered = false;

  void _setHovered(bool value) {
    if (_hovered != value) setState(() => _hovered = value);
  }

  @override
  Widget build(BuildContext context) {
    final child = widget.builder(context, _hovered, null);
    return MouseRegion(
      cursor: widget.cursor,
      onEnter: (_) => _setHovered(true),
      onExit: (_) => _setHovered(false),
      child: widget.onTap == null
          ? child
          : GestureDetector(
              onTap: widget.onTap,
              behavior: HitTestBehavior.opaque,
              child: child,
            ),
    );
  }
}
