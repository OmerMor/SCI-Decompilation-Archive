;;; Sierra Script 1.0 - (do not remove this comment)
(script# 58)
(include game.sh)
(use Main)
(use Intrface)
(use NewWalk)
(use LoadMany)
(use Follow)
(use Avoider)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm58 0
)

(instance rm58 of Room
	(properties
		picture 558
		west 72
	)
	
	(method (init)
		(self style: WIPEDOWN)
		(LoadMany VIEW 566 18 440 7 4 30)
		(Load PICTURE 58)
		(Load SOUND 39 59)
		(super init:)
		(giant
			posn: 120 110
			cycleSpeed: 1
			moveSpeed: 1
			setPri: 9
			setCycle: Walk
			setAvoider: Avoider
			setMotion: MoveTo 300 110
			init:
		)
		(HandsOff)
		(self setScript: skyDiver)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
	)
)

(instance giant of Actor
	(properties
		view 566
		loop 1
	)
)

(instance skyDiver of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				(Print 58 0 #at 25 20 #width 260 #mode 1 #dispose)
				(DisplayOldGraphics)
				(ego
					init:
					ignoreHorizon: TRUE
					view: 18
					posn: 182 -40
					yStep: 14
					illegalBits: 0
					setCycle: 0
					setMotion: MoveTo 182 148 self
				)
			)
			(2
				(ego setLoop: 1 cycleSpeed: 1 setCycle: CycleTo 2 1 self)
			)
			(3
				((ScriptID 0 6) stop:)
				((ScriptID 0 5) number: 59 loop: 1 play:)
				(self cue:)
			)
			(4
				((ScriptID 0 6) number: 39 loop: -1 play:)
				(ShakeScreen 6)
				(ego setCycle: EndLoop)
				(= seconds 3)
			)
			(5
				(ego setLoop: 2 setCel: 0)
				((ScriptID 0 5) stop: dispose:)
				(= cycles 2)
			)
			(6
				(ego cycleSpeed: 2 setCycle: EndLoop self)
			)
			(7
				(ego view: 30 loop: 0 cel: 0 setCycle: EndLoop self)
			)
			(8
				(cls)
				(ego
					setPri: -1
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 2 2
					view: 7
					setLoop: -1
					loop: 2
				)
				(curRoom drawPic: 58 DISSOLVE)
				(giant view: 440 setStep: 4 3)
				(= cycles 10)
			)
			(9
				(DisplayNewGraphics)
				(giant
					setPri: -1
					setCycle: NewWalk
					setMotion: Follow ego 20
				)
				(ego view: 4 setCycle: Walk setMotion: MoveTo -20 148)
				(self dispose:)
			)
		)
	)
)
